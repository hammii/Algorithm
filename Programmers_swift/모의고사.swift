import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let a1 = [1,2,3,4,5]
    let a2 = [2,1,2,3,2,4,2,5]
    let a3 = [3,3,1,1,2,2,4,4,5,5]
    var winner = [0,0,0]
    var result = [Int]()
    
    for i in 0..<answers.count {
        if answers[i] == a1[i % a1.count] {
            winner[0] += 1
        }
        if answers[i] == a2[i % a2.count] {
            winner[1] += 1
        }
        if answers[i] == a3[i % a3.count] {
            winner[2] += 1
        }
    }
    
    for i in 0...2 {
        if winner[i] == winner.max()! {
            result.append(i+1)
        }
    }
    
    return result
}
