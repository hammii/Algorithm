import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var result = [Int]()
    
    for c in commands {
        let arr = array[c[0]-1...c[1]-1].sorted()
        result.append(arr[c[2]-1])
    }
    
    return result
}
