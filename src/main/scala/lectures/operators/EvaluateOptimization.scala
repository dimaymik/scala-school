package lectures.operators

import lectures.functions.{Computation, CurriedComputation, Data, FunctionalComputation}

/**
  * В задачке из lectures.functions.Computations, мы реализовали
  * один и тот же метод 3-я разными способами
  *
  * Пришло время оценить на сколько разные имплементации
  * отличаются друг от друга по производительности
  *
  * Для этого, раскомментируйте код, выполните в циклах вызов 3-х имплементаций
  * Оцените разницу во времени выполнения и объясните ее происхожение
  *
  */
object EvaluateOptimization extends App with Data {

  val startTimestamp = System.currentTimeMillis()

  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 Computation.computation(
  for(i <- 1 to 100) {
    Computation.computation(filterData, dataArray)
  }
  println("elapsed time in Computation.computation " + (System.currentTimeMillis() - startTimestamp))


  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 CurriedComputation.partiallyAppliedCurriedFunction

  val startTimestamp_C = System.currentTimeMillis()
  for(i <- 1 to 100) {
      CurriedComputation.partiallyAppliedCurriedFunction(dataArray)
  }
  val cur_t = (System.currentTimeMillis() - startTimestamp_C)
  println("elapsed time in CurriedComputation " + cur_t)

  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 FunctionalComputation.filterApplied

  val startTimestamp_F = System.currentTimeMillis()
  for(i <- 1 to 100) {
    FunctionalComputation.filterApplied(dataArray)
  }
  val func_t = System.currentTimeMillis() - startTimestamp_F
  println("elapsed time in FunctionalComputation " + func_t)

  // ВЫВЕСТИ РАЗНИЦУ В ПРОДОЛЖИТЕЛЬНОСТИ ВЫПОЛНЕНИЯ МЕЖДУ КАРРИРОВАННОЙ ВЕРСИЕЙ
  // И ФУНКЦИОНАЛЬНОЙ

    val diff = cur_t - func_t

    println(s"Difference is about $diff milliseconds")
}

