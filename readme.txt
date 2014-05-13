To do Project 4, if you want to use source code from Project3, you may make some 
changes in Parser.java and Compiler.java.

Changes from Lab 3: Symbols

1. The Parser.parse method now returns a Command node representing an AST.
2. Modify the Compiler.main driver to print out the returned AST.
3. Add the ast package, which contains an implementation for each of the AST 
nodes.
4. Add helper methods to Parser: Token expectRetrieve(NonTerminal nt) and Token 
expectRetrieve(Token.Kind kind).
5. Change many (but not necessarily all) of the signatures of the Parser's 
recursive descent methods to return an ast node instead of void.
   for example, in Parser.java,
   you should change public void literal() into public ast.Expression literal()
   you should change public void designator() into public ast.Expression 
	designator()
   you should change public void public variable_declaration() into 
	ast.VariableDeclaration variable_declaration()
   you should change public void public function_definition() into 
	ast.FunctionDefinition function_definition()
   you should change public void assignment_statement() into public 
	ast.Assignment assignment_statement()
   ......
   etc.

   In a word, change many of the signatures of the Parser's recursive descent 
	methods to return an ast node instead of void.