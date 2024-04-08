# Programación orientada a aspecto

Es para que el código sea mas reutilizables, compacto y modular.
* Aspects : Es un aspecto una modulación es una tareas o proceso que es el interceptor

* Joint Point : cuando se ejecuta e metido es donde interceptamos representando la ejecución del un aspecto.

* Advice : es cuando se ejecuta el punto de unción de un Joint Point.

* Pointcuts : es una expresión que agrupa uno o mas punto de Joint Point.

* After returning advice : consejo para ser ejecutado después de ejecutar un metodo se completado con normalidad, cuando se retorna un valor/objeto.

* After throwing advice : se ejecuta si un método lanza una expresión.

* After (finally) advice : se ejecuta independientemente de si un método retorna/finaliza o si lanza una excepción.

* Around advice : envuelve una invocación de método, es el mas poderoso puede realizar tareas personalizadas antes y después sede la invocación de método.
