func solution(_ phone_number:String) -> String {
    let phone_star = String(phone_number.map { _ in "*"})
    let cutIdx = String.Index(encodedOffset: phone_number.count - 4)

    return phone_star.substring(to: cutIdx) + phone_number.substring(from: cutIdx)
}
