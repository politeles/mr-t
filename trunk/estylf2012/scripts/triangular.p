#!/usr/bin/gnuplot
#

###############################################
# GNU plot script for the figures in the paper#
# Jose Enrique Pons
# jpons@decsai.ugr.es
# #############################################

reset

set terminal latex

set output 'convexhull.tex'
set size 3.1/5,3/3


# Plot two triangular membership functions:

# Starting point:
ds = 5
as = 3
bs = 3

# ending point

de = 9
ae = 2
be = 1

# convex hull

alpha = 2
beta = 5
gamma = 9
delta = 10

# triangular function
t(x) = x >= (ds - as) && x < ds ? (x - (ds-as)) / (ds - (ds -as)) : x == ds ? 1 : x > ds && x< (ds+bs)? ((ds+bs) -x) / ( ds +bs - ds ) : 0

e(x) = x >= (de - ae) && x < de ? (x - (de-ae)) / (de - (de -ae)) : x == de ? 1 : x > de && x< (de+be)? ((de+be) -x) / ( de +be - de ) : 0


m(x) = x >= beta && x <= gamma ? 1 : x >= alpha && x < beta ? (x-alpha)/(beta - alpha) : x>= gamma && x<= delta ? (delta - x ) / (delta - gamma) : 0


set xrange [0:10]
set yrange [0:1.10]
set key at 4,1
set tics scale 0.75

set xtics 1
set ytics 0.1

set title 'Convex hull Transformation'

#set label 1 'Possibility' at graph -0.2, graph 0.5

set ylabel 'Possibility' 
# set nokey

# ,
plot  m(x) with linespoints lt 3 pt 8  title "T", t(x) with linespoints lt 1 pt 4 title "X",e(x) with linespoints lt 8 pt 6 title "Y"

