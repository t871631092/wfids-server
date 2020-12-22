package TwentyA101.WFIDS.A101.dao;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


public class BaseDAO{
    @Bean
    @Primary
    public Dao getDao(DataSource dataSource) {
        // 创建一个NutDao实例,在真实项目中, NutDao通常由ioc托管, 使用注入的方式获得.
        Dao dao = new NutDao(dataSource);
        return dao;
    }
}
