class MonadTest extends munit.FunSuite {

  test("flatMap should return the contained value") {

    val turtlesMonadFlat = Monad
      .of("Turtle")
      .flatMap(_ + "s");

    val sixMonad = Monad
      .of(5)
      .flatMap(_ + 1);

    val fourMonad = Monad
      .of("Four")
      .flatMap(_.length);

    val sumMonad = Monad
      .of(List(1, 2, 4, 8, 16, 32))
      .flatMap(_.sum);

    assertEquals(turtlesMonadFlat, "Turtles");
    assertEquals(sixMonad, 6);
    assertEquals(fourMonad, 4);
    assertEquals(sumMonad, 63);

  }

}
