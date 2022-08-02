func solution(_ a:Int, _ b:Int) -> Int64 {
    let first = a < b ? a : b
    let second = a < b ? b : a
    var result: Int64 = 0
    
    for i in first...second {
        result += Int64(i)
    }
    return result
}
