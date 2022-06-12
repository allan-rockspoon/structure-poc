package com.example.core.domain

import com.rockspoon.core.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 * Handling an exception (emit [UseCasae.Result.Error] to the result) is the subclasses's responsibility.
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

	operator fun invoke(parameters: P): Flow<UseCase.Result<R>> = execute(parameters)
		.catch { e ->
			emit(UseCase.Result.Error(Exception(e)))
		}
		.flowOn(coroutineDispatcher)

	protected abstract fun execute(parameters: P): Flow<UseCase.Result<R>>
}
