package utilites

import java.text.DecimalFormat

object TestTruncate extends App{
val num=3.34543545545454546465
  val formatter = new DecimalFormat("#.###")
println(formatter.format(num))
//  println(BigDecimal(num).setScale(9,BigDecimal.RoundingMode.HALF_EVEN).toDouble)
}
