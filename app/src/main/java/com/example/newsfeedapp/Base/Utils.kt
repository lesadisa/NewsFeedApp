package com.example.newsfeedapp.Base


/* inline функция - способ переставить кусок byte-кода в другое место с целью
оптимизации ускорения кода и овеществление типа. Сама функция attempt
делает лишь 1 действие - заворачивает результат, который
пришел снизу (ошибка или данные) в метод try-catch */

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}