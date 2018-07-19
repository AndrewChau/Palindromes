/**
  * Kwan Yin Andrew Chau 2018
  */

import org.scalatest._

class PalindromesSpec extends FlatSpec {

    val Challenges = List(
        "A but tu.ba." -> Some("abuttuba"),
        "A car, a man, a maraca." -> Some("acaramanamaraca"),
        "A dog, a plan, a canal: pagoda." -> Some("adogaplanacanalpagoda"),
        "A dog! A panic in a pagoda!" -> Some("adogapanicinapagoda"),
        "A lad named E. Mandala" -> Some("aladnamedemandala"),
        "A man, a plan, a canal: Panama." -> Some("amanaplanacanalpanama"),
        "A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!" -> Some("amanaplanacatahamayakayamahatacanalpanama"),
        "A new order began, a more Roman age bred Rowena." -> Some("aneworderbeganamoreromanagebredrowena"),
        "A nut for a jar of tuna." -> Some("anutforajaroftuna"),
        "A Santa at Nasa." -> Some("asantaatnasa"),
        "A Santa dog lived as a devil God at NASA." -> Some("asantadoglivedasadevilgodatnasa"),
        "A tin mug for a jar of gum, Nita." -> Some("atinmugforajarofgumnita"),
        "A Toyota! Race fast, safe car! A Toyota!" -> Some("atoyotaracefastsafecaratoyota"),
        "A Toyota’s a Toyota." -> Some("atoyotasatoyota"),
        "Able was I ere I saw Elba." -> Some("ablewasiereisawelba"),
        "Acrobats stab orca." -> Some("acrobatsstaborca"),
        "Aerate pet area." -> Some("aeratepetarea"),
        "Ah, Satan sees Natasha!" -> Some("ahsatanseesnatasha"),
        "Aibohphobia (fear of palindromes)" -> Some("aibohphobia"),
        "Air an aria." -> Some("airanaria"),
        "Al lets Della call Ed Stella." -> Some("alletsdellacalledstella"),
        "alula" -> Some("alula"),
        "Amen icy cinema." -> Some("amenicycinema"),
        "Amore, Roma." -> Some("amoreroma"),
        "Amy, must I jujitsu my ma?" -> Some("amymustijujitsumyma"),
        "Ana" -> Some("ana"),
        "Animal loots foliated detail of stool lamina." -> Some("animallootsfoliateddetailofstoollamina"),
        "Anna" -> Some("anna"),
        "Anne, I vote more cars race Rome to Vienna." -> Some("anneivotemorecarsracerometovienna"),
        "Are Mac ‘n’ Oliver ever evil on camera?" -> Some("aremacnoliverevereviloncamera"),
        "Are we not drawn onward to new era?" -> Some("arewenotdrawnonwardtonewera"),
        "Are we not drawn onward, we few, drawn onward to new era?" -> Some("arewenotdrawnonwardwefewdrawnonwardtonewera"),
        "Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era." -> Some("arewenotpurenosirpanamasmoodynoriegabragsitisgarbageironydoomsamanaprisoneruptonewera"),
        "Art, name no tub time. Emit but one mantra." -> Some("artnamenotubtimeemitbutonemantra"),
        "As I pee, sir, I see Pisa!" -> Some("asipeesiriseepisa"),
        "Avid diva." -> Some("aviddiva"),
        "qqqqppoabaodu" -> Some("oabao"),
        "qqqqqqppoabaodu" -> Some("qqqqqq")
    )

    "The longest palindromes" should "be found" in {
        Challenges.foreach({
            case (c, r) => assert(Palindromes.longestPalindrome(c) === r)
        })

        Palindromes.printPalindromes(Challenges.map(_._1))
    }
}
