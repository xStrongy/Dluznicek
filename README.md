# Dluznicek
Zadání: Cílem je naprogramovat aplikaci pro výdaje/dluhy. např. jedu s kamarády na dovolenou na lyže. Mohu si vytvoiřit skupinu "Dovolená" a do ní zapisovat všechny výdaje, co kdo za koho zaplatil. Aplikace poté bude vypisovat kolik kdo dluží nebo má přeplaceno. 
Aplikace by měla umět (zadání):
Přihlášení uživatele (uložení do DB). Vytváření skupin pro uživatele. Přerozdělování peněz z různých nákupů pro jednotlivé uživatele v rámci skupiny. Poznámky

Realita:
Přihlašování uživatele pomocí FireBase DB. Vytváření různách skupin (např. Dovolená, Oslava). Skupiny se rozlišují podle jména tzn. Nemohu mít pojmenované stejně 2 skupiny. Každá skupina je jiná. Do každé skupiny mohu přidat libovolný počet lidí (Lidé už nejsou ukládaní v DB). Do každé skupiny mohu přidat libovonlný počet plateb. Každou platbu mohu pojmenovat, mohu zvolit cenu a mohu zvolit za koho všeho platím. Aplikace pak v každé skupině píše celkovou útratu. Seznam plateb a kdo kolik dluží/má přeplaceno.

Všechny skupiny pak ukládám do SharedPReferences, ze kterých data následovně i tahám.
