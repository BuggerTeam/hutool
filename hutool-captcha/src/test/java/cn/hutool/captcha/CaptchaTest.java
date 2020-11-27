package cn.hutool.captcha;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.lang.Console;

import java.awt.*;

/**
 * 直线干扰验证码单元测试
 * 
 * @author looly
 *
 */
public class CaptchaTest {
	public static final String PATH = System.getProperty("user.dir")+ "\\src\\test\\java\\cn\\hutool\\captcha\\image\\";

	// 验证码
	@Test
	public void lineCaptchaTest1() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

		// 获取验证码的英文字母
		Assert.assertNotNull(lineCaptcha.getCode());
		Console.log(lineCaptcha.getCode());

		// 验证用户输入的字符串是否与生成的验证码匹配
		Assert.assertTrue(lineCaptcha.verify(lineCaptcha.getCode()));
	}

	// 验证码 - 内容为数字和字母，背景为线条
	@Test
	@Ignore
	public void lineCaptchaTest2() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
		// LineCaptcha lineCaptcha = new LineCaptcha(200, 100, 4, 150);

		// 图形验证码写出，可以写出到文件，也可以写出到流
		lineCaptcha.write(PATH + "image_LineCaptcha1.png");
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");

		lineCaptcha.createCode();
		lineCaptcha.write(PATH + "image_LineCaptcha2.png");
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");
	}

	// 验证码 - 内容为数字和字母，背景为线条
	@Test
	@Ignore
	public void lineCaptchaTest3() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 70, 4, 15);

		lineCaptcha.setBackground(Color.yellow);
		lineCaptcha.write(PATH + "image_LineCaptcha3.png");
	}

	// 验证码 - 内容为数学计算
	@Test
	//@Ignore
	public void lineCaptchaWithMathTest() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 80);

		lineCaptcha.setGenerator(new MathGenerator());
		lineCaptcha.setTextAlpha(0.8f);
		lineCaptcha.write(PATH + "image_LineCaptcha_Math.png");
	}

	// 验证码 - 内容为字符，背景为圆形
	@Test
	@Ignore
	public void circleCaptchaTest() {
		// 定义图形验证码的长和宽
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
		// CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);

		// 图形验证码写出，可以写出到文件，也可以写出到流
		captcha.write(PATH + "image_CircleCaptcha.png");

		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}

	// 验证码 - 内容为数字和字母，背景为扭曲干扰线
	@Test
	@Ignore
	public void ShearCaptchaTest() {
		// 定义图形验证码的长和宽
		ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(203, 100, 4, 4);
		// ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);

		// 图形验证码写出，可以写出到文件，也可以写出到流
		captcha.write(PATH + "image_ShearCaptcha.png");

		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}

	// 验证码 - 内容为数学计算，背景为扭曲干扰线
	@Test
	@Ignore
	public void ShearCaptchaWithMathTest() {
		// 定义图形验证码的长和宽
		ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
		captcha.setGenerator(new MathGenerator());
		// ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);

		// 图形验证码写出，可以写出到文件，也可以写出到流
		captcha.write(PATH + "image_ShearCaptcha_Math.png");

		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}
}
