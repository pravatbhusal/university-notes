# Mapping
Compare a "read" DNA strand to a large DNA strand and find the offset (location) of where it occurs.

Why mapping is difficult?
- 100 of millions of short reads
- billions of bases to search through
- approximate matching
- looking for a tiny pattern (~100 - 120 base pairs read) in a large, often redundant sequence

Edit Distance: Minimum number of edits (substitutions, deletions, insertions) required to turn a string to another
- Ex: v = ACAGA, w = ATCAGA so there's an editing distance of 1

Hamming Distance: Minimum number of subsititions required to turn one string to another
- Ex: v = ACA, w = ACT so there's a hamming distance of 1

However, we only focus on edit distance when mapping.

# Edit Distance Formula
- edit_distance_formula = {[dn-1, m-1 + Csub(Vn, Wm)], [dn, m-1 + Cins], [dn-1, m + Cdel]}
    - edit distance formula equals to the minimum value of the three formulas
    - Each formula is the cost of substution, deletion, or insertion respectively
    
# Dynamic Programming with an Edit Distance Matrix
Fill an edit distance matrix with the rows being the first DNA strand, the column being the second DNA stand. Then, add the minimum cost of substititing, deletion, or insertions into the row, column
- Helps break up complex problems into smaller subproblems

