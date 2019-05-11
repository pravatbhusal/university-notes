# First Generation Sequencing (Sanger DNA Replication)
- Primer and DNA Template
- ddNTPs (cannot incorporate another base to the DNA string, stops it from replication) and flourochromes
- DNA Polymerase
- dNTPs (dATP, dCTP, dGTP, and dTTP)
Input all of these items into a Gel-electrophoresis to get the bases of the DNA
- Disadvantage: Can only use a small number of sequences at a time
Ex: Human Genome Project
- Sequence 3.3 billion base pairs of the human genome

# Second Generation Sequencing (Next Generation Sequencing)
- Library preperation
- Cluster generation / amplification (amplifies a weak template DNA so that signals can be easier to detect)
- Sequencing by synthesis
- Billions of Sanger reactions happening parallel at the same time
For every read, there outputs 2 strands.

# NGS vs FGS 
- NGS is much faster than FGS
- NGS is cheaper and cost effective due too efficiency <- approx. $20 for a million sequences
- One disadvantage of NGS: Receive tiny sequences (reads) of the original sequence, must put back together

# Depth of Coverage?
- coverage = (read count * read length) / total genome size
Ex: Read count = 1000, read length = 2 x 150 base pairs = 300 bp, so coverage/genome size = 2 million base pairs

Ex: Are we at a $1000 human genome yet?
- 30x coverage required for whole genome sequencing
- Human genome = 3 giga base pairs = 3*10^9
- Typical read length = 2 * 150 base pairs = 300 bp
- Price of sequencing = $20 per million reads
Use formula, so 30x = (x * 300bp) / 3*10^9, so x = $6000 yes we are at a $1000 human genome

# Multiplexing
- Allows for us to input lots of DNA samples for the same sequencing run

# Adapter
- Allows template to attach to cluster in flowcell
- Has a primer to start synthesis from
- Has barcodes for multiplexing
- Pieces of the Adapter: Barcode/Index, Sequencing Primer, Sequencing Complement

# Base Quality
- Probability of Error = 10^(-Q/10) <- A Phred score used for types of qualities
We use high-quality data so the base the quality is good and decreases proability of error

# Limitations / Problems
- Amplifications may cause problems
    - Clusters are made with PCR amplifications
- Short reads are difficult to assemble
    - Too short to span long repeat regions
    - Difficult to detect large structural variations like inversions