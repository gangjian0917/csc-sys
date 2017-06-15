package com.jam.util.identicon;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jam.javautils.string.StringUtil;
import com.google.common.base.Preconditions;
import com.jam.common.config.SiteConfig;
import com.jam.javautils.encrypt.EncryptionUtil;
import com.jam.util.identicon.generator.IBaseGenartor;
import com.jam.util.identicon.generator.impl.MyGenerator;

import lombok.extern.log4j.Log4j;

/**
 * Author: Bryant Hang Date: 15/1/10 Time: 下午2:42
 */
@Component
@Log4j
public class Identicon {

	@Autowired
	private SiteConfig siteConfig;

	private IBaseGenartor genartor;

	public Identicon() {
		this.genartor = new MyGenerator();
	}

	public BufferedImage create(String hash, int size) {
		Preconditions.checkArgument(size > 0 && StringUtil.notBlank(hash));

		boolean[][] array = genartor.getBooleanValueArray(hash);

		// int ratio = DoubleMath.roundToInt(size / 5.0, RoundingMode.HALF_UP);
		int ratio = size / 6;

		BufferedImage identicon = new BufferedImage(ratio * 6, ratio * 6, BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = identicon.getGraphics();

		graphics.setColor(genartor.getBackgroundColor()); // 背景色
		graphics.fillRect(0, 0, identicon.getWidth(), identicon.getHeight());

		graphics.setColor(genartor.getForegroundColor()); // 图案前景色
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (array[i][j]) {
					graphics.fillRect(j * ratio + 35, i * ratio + 35, ratio, ratio);
				}
			}
		}

		return identicon;
	}

	public void generator(String fileName) {
		Identicon identicon = new Identicon();

		String md5 = EncryptionUtil.md5(StringUtil.randomString(6));

		BufferedImage image = identicon.create(md5, 420);

		try {
			String dir = siteConfig.getAvatarPath();
			if (StringUtil.isBlank(dir)) {
				throw new RuntimeException("头像文件目录为空，请检查配置文件config.yml");
			}

			File fdir = new File(dir);
			if (!fdir.exists()) {
				log.info("目录不存在，创建目录：dir:" + dir);
				fdir.mkdirs();
			}

			String name = dir + fileName + ".png";
			File file = new File(name);
			if (!file.exists())
				file.createNewFile();
			ImageIO.write(image, "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
