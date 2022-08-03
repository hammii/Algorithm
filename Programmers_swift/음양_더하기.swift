import Foundation

func solution(_ absolutes:[Int], _ signs:[Bool]) -> Int {
    var result = 0

    for i in 0..<absolutes.count {
        result += absolutes[i] * (signs[i] ? 1 : -1)
    }

    return result
}
