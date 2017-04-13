[y1, Fs1] = wavread('t1.wav');
[y2, Fs2] = wavread('t2.wav');
sound(y1);
sound(y1);
sound(y1, Fs1);
sound(y2, Fs2);
t1 = [1/Fs1:1/Fs2:length(y1)/Fs1];
t2 = [1/Fs2:1/Fs2:length(y2)/Fs2];
t1 = [1/Fs1:1/Fs1:length(y1)/Fs1];
ax = subplot(2,1,1)
ax = subplot(2,1,1)
ax = subplot(2,1,2)
ax1 = subplot(2,1,1);
ax2 = subplot(2,1,2);
plot(ax1,y1,t1);
plot(ax2,y2,t2);
plot(ax1,t1,y1);
plot(ax2,t2,y2);
linkaxes(ax1:ax2,'x');
C = intersect(y1,y2);
plot(C);

ax1 = subplot(2,1,1);
ax2 = subplot(2,1,2);
ax1 = subplot(3,1,1);
ax2 = subplot(3,1,2);
ax3 = subplot(3,1,3);

plot(ax1,t1,y1);
plot(ax2,t2,y2);
linkaxes(ax1:ax2,'x');
[y,Fs] = intersect(y1,y2);
t = [1/Fs:1/Fs:length(y)/Fs];

filename = 'h.wav';
filename = 'C:\h.wav';
