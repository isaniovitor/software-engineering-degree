def counting_lexemes(code, lexeme):  
  cont = 0

  while (code.find(lexeme) != -1):
    code = code[code.find(lexeme) + len(lexeme) : len(code)]
    cont += 1
  
  return cont

code = input()
lexeme = input()
print(counting_lexemes(code, lexeme))