class MonadTest extends munit.FunSuite {

  test("flatMap should return the contained value") {

    val turtlesMonadFlat = Monad
      .of("Turtle")
      .flatMap(_ + "s");

    assertEquals(turtlesMonadFlat, "Turtles");

  }

}
