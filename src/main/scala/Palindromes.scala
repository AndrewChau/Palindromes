/**
  * Kwan Yin Andrew Chau 2018
  */

object Palindromes extends App {

    val Challenges = List(
        "aa", "axa", "babad", "cbbd", "qqqqppabadu", "poabaoduyyyy", "poabaoduzzzzzz", "qqqqppoabaodu", "abcdefg")
    printPalindromes(Challenges)

    def longestPalindrome(s: String): Option[String] = {
        val letters = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase.split("")

        def validIndex(index: Int) = index >= 0 && letters.length > index
        def letterAt(index: Int): Option[String] = if (validIndex(index)) Some(letters(index)) else None
        def getLongest(s1: String, s2: String): String = if (s1.length > s2.length) s1 else s2

        def testNextPivot(currentPalindrome: String, pivot: Int): String = {
            val palindromeFromPivot = testPivot(pivot)
            val longestPalindrome = getLongest(currentPalindrome, palindromeFromPivot)

            if(validIndex(pivot + 1)) testNextPivot(longestPalindrome, pivot + 1)
            else longestPalindrome
        }

        def testPivot(currentPivot: Int): String = {
            if (validIndex(currentPivot)) {
                val leftOfPivot = currentPivot - 1
                val rightOfPivot = currentPivot + 1

                // Testing to the left and right of the current pivot using the current as the center
                val currentString = letters(currentPivot)
                val centerPalindrome = buildPalindrome(currentString, leftOfPivot, rightOfPivot)

                // Testing between the current pivot and the right of it
                val palindromeBetweenCurrentAndRight = buildPalindrome("", currentPivot, rightOfPivot)

                getLongest(centerPalindrome, palindromeBetweenCurrentAndRight)
            } else ""
        }

        def buildPalindrome(currentString: String, leftIndex: Int, rightIndex: Int): String = {
            (letterAt(leftIndex), letterAt(rightIndex)) match {
                case (Some(lhs), Some(rhs)) if lhs.equals(rhs) =>
                    buildPalindrome(s"$lhs$currentString$rhs", leftIndex - 1, rightIndex + 1)
                case _ => currentString
            }
        }

        val longestPalindrome = testNextPivot("", 0)
        if(longestPalindrome.length > 1) Some(longestPalindrome) else None
    }

    def printPalindromes(challenges: List[String]): Unit = {
        challenges.foreach(c => {
            println(s"\n$c")
            println(longestPalindrome(c).getOrElse("--"))
        })
    }
}
