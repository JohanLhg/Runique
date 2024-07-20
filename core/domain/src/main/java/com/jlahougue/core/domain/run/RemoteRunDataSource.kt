package com.jlahougue.core.domain.run

import com.jlahougue.core.domain.util.DataError
import com.jlahougue.core.domain.util.EmptyResult
import com.jlahougue.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(runId: String): EmptyResult<DataError.Network>
}