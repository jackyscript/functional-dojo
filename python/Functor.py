class Functor():

    def __init__(self, value):
        self._value = value

    @staticmethod
    def of(value):
        return Functor(value)

    def inspect(self):
        print(self._value)

    def map(self, function):
        if self._value is None:
            return Functor(None)
        else:
            return Functor(function(self._value))

Functor.of(5).map(lambda a: Functor.of(a + 1)).inspect() # another functor