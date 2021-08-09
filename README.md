# sentencelib

- feat: feature 新功能 / 功能变动
- fix: 修补bug
- docs: documentation 更新了 文档/注释
- style: 格式调整，比如执行了format、更改了tab显示等
- refactor: 重构，指的是代码结构的调整，比如使用了一些设计模式重新组织了代码，既不是新增功能，也不是修改bug的代码变动
- perf: 对项目或者模块进行了性能优化。比如一些jvm的参数改动，把stringbuffer改为stringbuilder等
- test: 测试代码
- build: 影响编译的一些更改，比如修改 maven 中 pom.xml 规则
- ci: 持续集成方面的更改，比如 Dockerfile / Github Action 的 yml 等
- chore: 构建过程或辅助工具的变动
- revert: 回滚了一些前面的代码





本来这个项目应该git到另外一个仓库下，但是很奇怪mavenpackage打包的时候删掉了pom的一个插件（当时是爆红的，而且打包的jar不能在服务器上跑，所以我才删除了），之后跑springbootapplication和test都无法正常运行了，报的错是没有配置数据库。所以重新开了一个仓库，把原来的代码复制粘贴成功运行，蛮怪的 。

原来部署jar到服务器的过程中，运行会报“Failed to get nested archive for entry BOOT-INF/lib/spring-kafka-2.2.7.RELEASE.jar”。windows命令行java -jar编译运行会报“没有主清单属性”。截止目前没有找到解决办法，插个眼看下一次能不能解决这个问题。windows命令行java -jar编译运行会报“没有主清单属性”。引入mavenplugin也不行

上面的所有问题都在我用idea重新初始化环境后解决了，而idea的自动spring init好像没有显式的引入mavenplugin但成功了，可能是别的依赖的缘故。因为只有初始化环境不是我做的，所以初始化环境很重要好吧。能用spring init就不要手动maven项目，现在服务器也能正常跑了（这个readme提醒自己初始化环境很重要，如果大多是自己写的建议自己配置）



