package org.saddyfire;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

/**
 * @author SaddyFire
 * @date 2022/1/23
 * @TIME:10:51 https://baomidou.com/pages/981406/
 */
public class Generator {
    public static void main(String[] args) {
        /**
         * 数据库配置(DataSourceConfig)
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/leadnews_user?serverTimezone=UTC",
                "root",
                "2323").build();

        /**
         * 全局配置(GlobalConfig)
         */
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride() //覆盖已生成的文件
//                .disableOpenDir()   //禁止打开输出目录
                .outputDir(System.getProperty("user.dir") + "/src/main/java")  //指定输出目录
                .author("SaddyFire")    //设置作者名
                .dateType(DateType.ONLY_DATE)   //时间策略
//                .enableSwagger()    //开启swagger模式
//                .commentDate()  //注释日期 默认值: yyyy-MM-dd
                .build();

        /**
         * 包配置(PackageConfig)
         */
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.heima.model.user") //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
                .entity("pojos")    //设置实体类包名
//                .service("serivce") //service包名
//                .serviceImpl("impl")    //Service Impl 包名
//                .mapper("mapper")     //Mapper 包名
//                .controller("controller")   //Controller 包名
//                .other("other")     //自定义文件包名
                .build();

        /**
         * 模板配置(TemplateConfig)
         */
//        new TemplateConfig.Builder()
//                .disable(TemplateType.ENTITY)   //禁用模板
//                .entity("/templates/entity.java")   //设置实体模板路径(JAVA)
//                .service("/templates/service.java")     //设置 service 模板路径
//                .serviceImpl("/templates/serviceImpl.java") //设置 serviceImpl 模板路径
//                .mapper("/templates/mapper.java")   //设置 mapper 模板路径
//                .mapperXml("/templates/mapper.xml") //设置 mapperXml 模板路径	/
//                .controller("/templates/controller.java")   //设置 controller 模板路径
//                .build();

        /**
         * 策略配置(StrategyConfig)
         */
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()    //开启大写命名
                .enableSkipView()   //开启跳过视图
                .disableSqlFilter() //禁用 sql 过滤
                .likeTable(new LikeTable("USER"))   //启用 schema
//                .addInclude("t_simple")     //模糊表匹配(sql 过滤)
                .addTablePrefix("t_", "c_") //模糊表排除(sql 过滤)
//                .addFieldSuffix("_flag")    //增加过滤字段前缀
//                .addFieldSuffix("") //增加过滤字段后缀
                .build();

        /**
         * Entity 策略配置
         */
        strategyConfig
                .entityBuilder()    //
//                .disableSerialVersionUID()  //禁用生成 serialVersionUID
//                .enableChainModel() //开启链式模型
                .enableLombok()     //开启lombok
                .enableRemoveIsPrefix() //开启boolean类型字段移出
                .enableTableFieldAnnotation()   //开启生成实体时生成字段注解
//                .enableActiveRecord()   //开启ActiveRecord模型
//                .versionColumnName("version")   //乐观锁字段名(数据库)
//                .versionPropertyName("version") //乐观锁属性名(实体)
//                .logicDeleteColumnName("deleted")   //逻辑删除字段名(数据库)
//                .logicDeletePropertyName("deleteFlag")  //逻辑删除属性名(实体)
                .naming(NamingStrategy.underline_to_camel)   //数据库表映射到实体的命名策略
                .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略
//                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")    //添加父类公共字段
//                .addIgnoreColumns("age")    //添加忽略字段
                .addTableFills(new Column("create_time", FieldFill.INSERT)) //添加表字段填充
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE)) //添加表字段填充
                .idType(IdType.AUTO)    //全局主键类型
//                .formatFileName("%sEntity")     //格式化文件名称
                .build();

        /**
         * Controller 策略配置
         */
//        strategyConfig
//                .controllerBuilder()    //
//                .enableHyphenStyle()    //开启驼峰转连字符
//                .enableRestStyle()      //开启生成@RestController 控制器
//                .formatFileName("%sController") //转换文件名称
//                .build();

        /**
         * Service 策略配置
         */
        strategyConfig
                .serviceBuilder()
                .formatServiceFileName("%sService") //formatServiceFileName(String)
                .formatServiceImplFileName("%sServiceImp")  //formatServiceImplFileName(String)
                .build();

        /**
         * Mapper 策略配置
         */
        strategyConfig
                .mapperBuilder()
                .superClass(BaseMapper.class)   //设置父类
                .enableMapperAnnotation()   //开启 @Mapper 注解
                .enableBaseResultMap()  //启用 BaseResultMap 生成
                .enableBaseColumnList() //启用 BaseColumnList
//                .cache(MyMapperCache.class)     //设置缓存实现类
                .formatMapperFileName("%sDao")  //格式化 mapper 文件名称
//                .formatXmlFileName("%sXml") //格式化 xml 实现类文件名称
                .build();

        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig);
        autoGenerator.execute();


    }
}
