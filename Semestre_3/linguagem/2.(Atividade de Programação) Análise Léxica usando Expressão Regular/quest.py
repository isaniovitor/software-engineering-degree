import re
import sys

class Token():
  def __init__(self,type, value, line, column):
    self.type = type
    self.value = value
    self.line = line
    self.column = column
  def __str__(self):
    return "Token(type='%s', value='%s', line=%d, column=%d)" % (self.type, self.value,self.line, self.column)

def tokenize(code):

    keywords = {'if', 'return','for'}

    token_specification = [
    
        ('NUMBER',   r'\d+(\.\d*)?'),  
        ('ASSIGN',   r'='),           
        ('END',      r';'),            
        ('ID',       r'[A-Za-z]+'),    
        ('OP',       r'[+\-*/]'),      
        ('NEWLINE',  r'\n'),           
        ('FP',       r'\)'),      
        ('FC',       r'\}'),      
        ('AP',       r'\('),      
        ('COMMA',       r'\,'),      
        ('LEFTBRACKET',       r'\['), 
        ('RIGHTBRACKET',       r'\]'),
        ('LT',       r'\<'),      
        ('AC',       r'\{'),
    ]


    tok_regex = '|'.join('(?P<%s>%s)' % pair for pair in token_specification)
    line_num = 1
    line_start = 0
    

    for mo in re.finditer(tok_regex, code):
        kind = mo.lastgroup
        value = mo.group()
        column = mo.start() - line_start
        if kind == 'NUMBER':
            value = float(value) if '.' in value else int(value)
        elif kind == 'ID' and value in keywords:
            kind = value
        elif kind == 'NEWLINE':
            line_start = mo.end()
            line_num += 1
            continue
        elif kind == 'SKIP':
            continue
       
        yield Token(kind, value, line_num, column)

data = sys.stdin.readlines()

code = ''.join(data)


for token in tokenize(code):
    print(token)