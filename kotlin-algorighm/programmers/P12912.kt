package programmers

fun main() {
    var a: Int = 3
    var b: Int = 5
    var answer: Long = solution(a, b)
    println("Answer = " + answer)
}

fun solution(a: Int, b: Int): Long {
    var answer: Long = 0

    if (a >= b) {
        for (i in b..a) {
            answer += i
        }
    } else if(b > a) {
        for (i in a..b) {
            answer += i
        }
    }
    return answer
}