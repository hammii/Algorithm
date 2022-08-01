func solution(_ arr:[Int]) -> [Int] {
    var result_arr = arr
    result_arr.remove(at: result_arr.firstIndex(of: result_arr.min()!)!)
    
    return result_arr.count == 0 ? [-1] : result_arr
}
