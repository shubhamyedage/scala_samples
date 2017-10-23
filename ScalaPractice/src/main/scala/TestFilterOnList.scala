///*
///**
//  * Created by synerzip on 24/5/16.
//  */
//class TestFilterOnList(private var _name: String, var _num: Int) {
//  //Getter
//  def name = _name
//
//  def num = _num
//
//  //Setter
//  def name_=(value: String): Unit = _name = value
//
//  def num_=(value: Int): Unit = _num = value
//
//  //toString
//  override def toString = _num + "" + _name
//
//}
//
//object Test {
//  def main(args: Array[String]) {
//    val myList1 = List(new TestFilterOnList("A", 1), new TestFilterOnList("B", 2))
//    //val myList2 = List(new TestFilterOnList("C", 3), new TestFilterOnList("D", 4))
//
//    //    myList1.foreach { test =>
//    //      val myList = test.fi
//    //    }
//
//    def  isfilter(test:TestFilterOnList):Boolean = return test.num == 1 && test.name.equals("A")
//    val myList = myList1.filter(a=>isfilter(a))
//    //val myList = myList1.filter(isfilter)
//    myList.foreach { test =>
//      println(test.toString)
//    }
//
//  }
//
//}*/
