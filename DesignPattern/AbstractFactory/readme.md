## 对比
1个工厂多个产品叫做简单工厂模式
多个工厂每个工厂对应1个产品叫做工厂方法
多个工厂每个工厂对应多个产品就做抽象工厂

### 缺点
如果想增加一个家庭表-Family，需要增加IFamuly，mysqlFamily和sqlserverFamily，同时修改IFactory，mysqlFactory和sqlserverFactory3个类

### UML图


![抽象工厂模式](uml/AbstractFactory-Improved.png)