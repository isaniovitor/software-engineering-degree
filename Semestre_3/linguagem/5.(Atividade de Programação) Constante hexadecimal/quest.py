import re

## Coloque aqui usa expressão regular
regexp = r'[0][xX][0-9A-Fa-f]+'


for string in input().split(' '):
  print( re.fullmatch(regexp, string) != None)