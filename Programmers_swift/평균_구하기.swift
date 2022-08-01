func solution(_ arr:[Int]) -> Double {
    var total = 0.0
    
    for a in arr {
        total += Double(a)
    }
    
    return total / Double(arr.count)
}
