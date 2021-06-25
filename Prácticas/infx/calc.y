%{
#include <stdio.h>
#include <math.h>
void yyerror(const char *s);
int yylex(void);
%}

%define api.value.type {double}
%token NUM
%left '-' '+'
%left '*' '/'
%left NEG
%right '^'


%% /* Grammer rules and actions follow */

input: /* empty */
     | input line
     ;

line: '\n'
    | exp '\n' { printf("\t%.10g\n", $1); }
    ;

exp: NUM { $$ = $1; }
   | exp '+' exp { $$ = $1 + $3; }
   | exp '-' exp { $$ = $1 - $3; }
   | exp '*' exp { $$ = $1 * $3; }
   | exp '/' exp { $$ = $1 / $3; }
   | '-' exp %prec NEG { $$ = -$2; }
   | exp '^' exp { $$ = pow($1, $3); }
   | '(' exp ')' { $$ = $2; }
   ;

%%

/* Additional C code */

int main(void) { return yyparse(); }

void yyerror(const char* s)
{
    fprintf(stderr, "%s\n", s);
}
