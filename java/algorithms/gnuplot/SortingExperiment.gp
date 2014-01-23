unset logscale
set logscale xy
set xrange [64:8192]
set yrange [4200:172000000]
plot "../experimentData/InsertionSort.dat" using 1:2 title 'InsertionSort' with linespoints, \
     "../experimentData/SelectionSort.dat" using 1:2 title 'SelectionSort' with linespoints, \
     "../experimentData/ShellSort.dat" using 1:2 title 'ShellSort' with linespoints, \
     "../experimentData/MergeSort.dat" using 1:2 title 'MergeSort' with linespoints, \
     "../experimentData/BottomUpMergeSort.dat" using 1:2 title 'BottomUpMergeSort' with linespoints, \
     "../experimentData/QuickSort.dat" using 1:2 title 'QuickSort' with linespoints, \
     "../experimentData/HeapSort.dat" using 1:2 title 'HeapSort' with linespoints
