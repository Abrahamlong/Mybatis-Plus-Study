package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/5
 *
 * 代码自动生成器
 */
public class AutoCode {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("abraham long");
        gc.setOpen(false);
        gc.setFileOverride(false);      // 设置文件是否覆盖
        gc.setServiceName("%sService");      // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        // 把这些配置加载到自动生成器中
        mpg.setGlobalConfig(gc);

        // 2.配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus?useSSL=true&useUnicode=true&characterEncoding=utf-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        // 把数据源配置加载到自动生成器中
        mpg.setDataSource(dsc);

        // 3.配置包
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("study");
        pc.setParent("com.example.mybatisplusdemo");
        pc.setEntity("auto_pojo");
        pc.setMapper("auto_mapper");
        pc.setService("auto_service");
        pc.setController("auto_controller");
        // 把包的配置加载到自动生成器中
        mpg.setPackageInfo(pc);

        // 4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");    // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);    // 自动LomBok
        strategy.setLogicDeleteFieldName("deleted");    // 逻辑删除
        // 自动填充配置
        TableFill createTime = new TableFill("createTime", FieldFill.INSERT);
        TableFill updateTime = new TableFill("updateTime", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        // 驼峰命名
        strategy.setRestControllerStyle(true);
        // localhost:/8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);
        // 把策略配置的信息加载到自动生成器中
        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();
    }
}
