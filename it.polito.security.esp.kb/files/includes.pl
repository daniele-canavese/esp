#!/usr/bin/perl

use strict;
use warnings;
use JSON;
use File::Slurp;
use File::Basename;
use Cwd "abs_path";

my $text = read_file($ARGV[0]);
$text =~ s/\/\/.*//g;

my $json = decode_json($text);
my $cFrontend = $json->{"tools"}->{"frontend"};
my $cppFrontend = "/opt/diablo-android-gcc-toolchain/bin/arm-linux-androideabi-g++";
my @preprocessFlags = @{ $json->{"src2bin"}->{"PREPROCESS"}->{"options"} };

my $cIncludes = `echo | $cFrontend @preprocessFlags -v -E - 2>&1`;
my $cppIncludes = `echo | $cppFrontend @preprocessFlags -v -E - 2>&1`;

my @includes = ();

push(@includes, ".");
if ($cIncludes =~ /#include "..." search starts here:\n((.|\n)*)#include <...> search starts here:\n((.|\n)*)End of search list.\n/m)
{
	push(@includes, split("\n", $1));
	push(@includes, split("\n", $3));
}
if ($cppIncludes =~ /#include "..." search starts here:\n((.|\n)*)#include <...> search starts here:\n((.|\n)*)End of search list.\n/m)
{
	push(@includes, split("\n", $1));
	push(@includes, split("\n", $3));
}

foreach my $i (@includes)
{
	$i =~ s/^\s+//;
	$i =~ s/\s*\\$//;
	print abs_path($i) . "\n";
}
