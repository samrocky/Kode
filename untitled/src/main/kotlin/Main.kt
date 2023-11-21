import java.io.BufferedReader
import java.nio.file.Path
import java.security.MessageDigest

@OptIn(ExperimentalStdlibApi::class)
fun String.toSha256(): String{
    val bytes =
        MessageDigest.getInstance("sha256").digest(this.toByteArray())
    return bytes.toHexString()
}

fun main(){
    val bufferedReader = BufferedReader(Path.)
}

data class PasswordsHash(
    val userName: String,
    val passHash: String
)