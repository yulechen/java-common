package com.github.yulechen.grammar.jdk8;

import java.util.Arrays;
import java.util.Collection;

public class StreamApi {

    public static void main(String[] args) {

        final Collection<Streams.Task> tasks = Arrays.asList(
                new Streams.Task( Streams.Status.OPEN, 5 ),
                new Streams.Task( Streams.Status.OPEN, 13 ),
                new Streams.Task( Streams.Status.CLOSED, 8 )
        );

        // Calculate total points of all active tasks using sum()
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter( task -> task.getStatus() == Streams.Status.OPEN )
                .mapToInt( Streams.Task::getPoints )
                .sum();

        System.out.println( "Total points: " + totalPointsOfOpenTasks );
    }


    public static class Streams  {
        private enum Status {
            OPEN, CLOSED
        };

        public static final class Task {
            private final Status status;
            private final Integer points;

            Task( final Status status, final Integer points ) {
                this.status = status;
                this.points = points;
            }

            public Integer getPoints() {
                return points;
            }

            public Status getStatus() {
                return status;
            }

            @Override
            public String toString() {
                return String.format( "[%s, %d]", status, points );
            }
        }
    }
}
