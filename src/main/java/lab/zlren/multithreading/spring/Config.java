package lab.zlren.multithreading.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zlren
 * @date 2018-03-09
 */
@Configurable
@ComponentScan("lab.zlren.multithreading.spring")
@EnableAsync
public class Config {

}
