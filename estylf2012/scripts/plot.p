#!/usr/bin/gnuplot
#

###############################################
# GNU plot script for the figures in the paper#
# Jose Enrique Pons
# jpons@decsai.ugr.es
# #############################################

reset

set terminal gif
set output 'trapezoidal.gif'



# Plot for a trapezoidal membership function

alpha = 2
beta = 4
gamma = 6
delta = 8

set nokey
set xrange [0:10]
set yrange [0:1.10]

set tics scale 0.75

set xtics 1
set ytics 0.1
set xtics ("$\alpha$" 2, "$\beta$" 4, "$\gamma$" 6, "$\delta$" 8)

set title 'Trapezoidal possibility distribution'
set xlabel ''
set ylabel 'Possibility'

m(x) = x >= beta && x <= gamma ? 1 : x >= alpha && x < beta ? (x-alpha)/(beta - alpha) : x>= gamma && x<= delta ? (delta - x ) / (delta - gamma) : 0

plot m(x)


