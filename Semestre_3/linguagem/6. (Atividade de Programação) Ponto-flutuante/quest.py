import re

code = input()


## Coloque aqui usa expressão regular
pattern = r'[+-]?((\d+\.\d*)|(\.\d+))'

for s in code.split():
  if re.fullmatch(pattern, s) :
    print(s) 