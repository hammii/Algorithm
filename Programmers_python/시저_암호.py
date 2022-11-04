def solution(s, n):
    answer = ''
    
    for alpha in s:
        if alpha == ' ':
            answer += ' '
            continue
            
        ascii = chr(ord(alpha) + n)
        
        if 'a'<=alpha<='z' and (not 'a'<=ascii<='z'):
            ascii = chr(ord(ascii) - 26)
        elif 'A'<=alpha<='Z' and (not 'A'<=ascii<='Z'): 
            ascii = chr(ord(ascii) - 26)
        answer += ascii

    return answer
