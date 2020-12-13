# Dluznicek
Zadání: Cílem je naprogramovat aplikaci pro výdaje/dluhy. např. jedu s kamarády na dovolenou na lyže. Mohu si vytvoiřit skupinu "Dovolená" a do ní zapisovat všechny výdaje, co kdo za koho zaplatil. Aplikace poté bude vypisovat kolik kdo dluží nebo má přeplaceno. 
Aplikace by měla umět (zadání):
Přihlášení uživatele (uložení do DB). Vytváření skupin pro uživatele. Přerozdělování peněz z různých nákupů pro jednotlivé uživatele v rámci skupiny. Poznámky

Realita:
Přihlašování uživatele pomocí FireBase DB. Vytváření různách skupin (např. Dovolená, Oslava). Každá skupina je jiná. Do každé skupiny mohu přidat libovolný počet lidí (Lidé už nejsou ukládaní v DB). Do každé skupiny mohu přidat libovonlný počet plateb. Každou platbu mohu pojmenovat, mohu zvolit cenu a mohu zvolit za koho všeho platím. Aplikace pak v každé skupině píše celkovou útratu. Seznam plateb a kdo kolik dluží/má přeplaceno.

Všechny skupiny pak ukládám do SharedPReferences, ze kterých data následovně i tahám.

Ošetřtení:
Samozřejmě jsem se snažil vše ošetřit, tak, aby uživatel nezpůsobil pád programu. Ošetřuji pžihlášení - kontroluji, zda uživatel opravdu zadal správné přihlašovací jméno i heslo. Skupiny se rozlišují podle jména tzn. Nemohu mít pojmenované stejně 2 skupiny. Každého uživatele v každé skupině rozlišuji IDčkem. Tzn. mohu mít více stejných jmén. V aktivitě pro přidání platby uživatel nejdřív musí vybrat kdo platí, poté se mu zobrazí všechny další možnosti, předcházím tomu, aby uživatel nezapomněl plátce vyplnit. Také popis platby je povinný.

Přihlašovací jméno: admin
heslo: admin
