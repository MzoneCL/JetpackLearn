## RoomTest

该 repo 写了一个关于 Room 使用的简单的例子



结合了 ViewModel + LiveData



## 踩坑

关于 Insert 注解返回值的问题

* Not sure how to handle insert method's return type. 



参考： https://stackoverflow.com/questions/57352175/not-sure-how-to-handle-insert-methods-return-type 

简单说就是，@Insert 注解标注的函数返回值有以下三种情况：

* 插入一条记录返回 Long
* 插入多条记录返回 long[] or Long[] 或 List 
* 如果你不在意插入记录的 id，返回 void



使用ViewModelProvider 一定记得添加
implementation 'androidx.lifecycle:lifecycle-viewmodel:2.2.0' 依赖呀，别再忘啦！！





## 学到的新东西

Kotlin 中静态方法 变量的实现

用到 companion object