import Foundation

func solution(_ n:Int) -> Int
{
    var answer:Int = 0
    let str = String(n)
    
    for s in str {
        answer += Int(String(s))!
    }
    
    return answer
}
