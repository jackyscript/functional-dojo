from Functor import Functor

class Monad(Functor):

    @staticmethod
    def of(value):
        return Monad(value)

    def map(self, function):
        return Monad.of(function(self._value));

    def flatMap(self, function):
        if self._value is None:
            return None
        else:
            return function(self._value)
        
        
Monad.of(5).flatMap(lambda a: Monad.of(a + 1)).inspect() # the value