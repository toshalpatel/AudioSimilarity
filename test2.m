[y1,Fs1] = wavread('t1.wav');
[y2,Fs2] = wavread('t2.wav');
T1 = [1/Fs1:1/Fs1:length(y1)/Fs1];
T2 = [1/Fs2:1/Fs2:length(y2)/Fs2];
figure
ax1 = subplot(3,1,1);
ax2 = subplot(3,1,2);
ax3 = subplot(3,1,3);
plot(ax1, y1, T1);
plot(ax2, y2, T2);
plot(ax1, T1, y1);
plot(ax2, T2, y2);
linkaxes(ax3:ax3, 'x');
linkaxes(ax1:ax3, 'x');
[C1,lag1] = xcorr[t2,t1];
[C1,lag1] = xcorr(T2,T1);
plot(ax3, lag1/Fs1, C1);
linkaxes(ax1:ax3,'x');
T2 = alignsignals(T2,T1);
RMSE = sqrt(mean((T2-T1).^2));
RMSE
plot(ax1, T1, y1);
plot(ax3, lag1/Fs1, C1);
 
grid(ax1, 'on');
grid(ax2, 'on');
grid(ax3, 'on');
