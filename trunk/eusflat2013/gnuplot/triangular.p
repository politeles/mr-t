#!/usr/bin/gnuplot
#

###############################################
# GNU plot script for the figures in the paper#
# Jose Enrique Pons
# jpons@decsai.ugr.es
# #############################################

reset

set term svg enhanced size 600,400
set output 'trapezoidal.svg'



# Plot of an UTI in the triangular model.
# We need 6 values:
# ts1, the value for ts^-
# ts, the value for ts
# ts2, the value for ts^+
# te1, the value for te^- 
# te, the value for te
# te2, the value for te^+

ts1 = 2
ts = 3
ts2 = 4

te1 = 8
te = 9
te2 = 10

#
# We use the ecuation of the line:
# y - y1 = m (x-x1)
# in this case m = 1 (alpha = 45 degrees)
# or m = -1 (alpha = -45 degrees)

# we define 6 functions, one for each line:
ls1(x) = x - ts1 
ls(x) = x- ts
ls2(x) = x- ts2

le1(x) = -x + te1
le(x) = -x + te
le2(x) = -x +te2

#
#now we define the two triangular membership functions:
# s(x) for the starting point
# e(x) for the ending point

s(x) = x == ts ? 1 : x >= ts1 && x < ts ? (x-ts1)/(ts - ts1) : x>= ts && x<= ts2 ? (ts2 - x ) / (ts2 - ts) : 0
e(x) = x == te ? 1 : x >= te1 && x < te ? (x-te1)/(te - te1) : x>= te && x<= te2 ? (te2 - x ) / (te2 - te) : 0

#
# and now we define mu_I
#
mui(x) = s(x) < e(x) ? s(x): e(x)

set xrange [ts1:te2]
set yrange [ts1:te2]




set nokey
set xrange [0:15]
set yrange [0:15]

set tics scale 0.75

set xtics 1
set ytics 1
# set xtics ("$\alpha$" 2, "$\beta$" 4, "$\gamma$" 6, "$\delta$" 8)

set title 'Uncertain Time Interval in Triangular Model'
set xlabel 'Time'
set ylabel 'Time'


set multiplot

call 'drawsurface.p' ts1 ts ts2 te1 te te2
plot ls1(x)
plot ls(x)
plot ls2(x)
plot le(x)
plot le1(x)
plot le2(x)


